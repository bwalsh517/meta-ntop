DESCRIPTION = "ntopng"
SECTION = "ntopng"
DEPENDS = "nDPI curl mariadb luajit json-c zeromq rrdtool geoip"
RDEPENDS_${PN} = "redis mariadb"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRCREV = "141c778cd94103c876cc75ad2dad74d27ae97c68"
SRC_URI = "git://github.com/ntop/ntopng.git;protocol=git;branch=2.4-stable \
		file://0001-disable-ndpi-check.patch \
                file://0002-do-no-access-usrlocal-opt.patch \
                file://0003-fix-compiler-detection.patch \
                file://0004-use-local-hiredis.patch \
"

S = "${WORKDIR}/git"

inherit autotools-brokensep gettext systemd

do_install_append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/packages/etc/systemd/system/ntopng.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += "\
               /usr/man/man8/ntopng.8 \
               ${systemd_unitdir}/system/ntopng.service \
               ${systemd_unitdir}/system/redis.service "

do_configure() {
    cd ${S}; ./autogen.sh
    oe_runconf
}

SYSTEMD_SERVICE_${PN} = "ntopng.service"
