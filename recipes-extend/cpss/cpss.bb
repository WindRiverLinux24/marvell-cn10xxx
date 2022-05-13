DESCRIPTION = "Marvell cn106xx cpss application"
PROVIDES += "cpss"

LICENSE = "CLOSED"

DEPENDS = "glibc"

SRC_URI = "https://www.marvell.com/content/dam/marvell/en/my-products/infrastructure-processors/octeon-arm/sdk/sdk11/qa/sdk11-22-05/generic-extensions/sources-cpss-SDK11.22.05.tar.bz2"
SRC_URI[sha256sum] = "548dc5c5f9c11cb70120538df54676177e8e023eb4ee50c92412d7cc9e3bc671"

SRC_URI += " \
    file://0001-Change-Makefile-to-fit-yocto.patch \
"

S = "${WORKDIR}/cpss-SDK11.22.05"

EXTRA_OEMAKE += " \
	CC='${CC}' LD='${CC}' CROSS_COMPILE=${TARGET_PREFIX} \
"

FILES_${PN} = " \
	/usr/bin/cpssDemo \
"

do_configure() {
    oe_runmake CPSS_FAMILY=DX -C ${S}/nwa clean
}

do_compile() {
    oe_runmake CPSS_FAMILY=DX -C ${S}/nwa
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/build_out_DX/appDemo ${D}${bindir}
}

INSANE_SKIP_${PN} += "ldflags"
FILES_${PN} += "${bindir}"
COMPATIBLE_MACHINE_marvell-cn106xx = "marvell-cn106xx"
COMPATIBLE_MACHINE ?= "^$"
