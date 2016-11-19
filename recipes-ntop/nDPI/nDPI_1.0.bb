DESCRIPTION = "nDPI"
SECTION = "ntopng"
DEPENDS = "libpcap"
RDEPENDS_${PN} += " libpcap"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=b52f2d57d10c4f7ee67a7eb9615d5d24"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "6450ae256cfd7a6006d39df4a29de32f2f6fb7eb"
SRC_URI = "git://github.com/ntop/nDPI.git;protocol=git;branch=1.8-stable"

S = "${WORKDIR}/git"

inherit autotools

# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""

