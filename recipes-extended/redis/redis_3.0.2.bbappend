FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://redis_sysctl.conf"

do_install_append() {
    install -d ${D}/${sysconfdir}/sysctl.d/
    install -m 0600 ${WORKDIR}/redis_sysctl.conf ${D}/${sysconfdir}/sysctl.d/redis.conf
}
