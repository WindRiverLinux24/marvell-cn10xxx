DESCRIPTION = "Marvell cn106xx cpss application"
PROVIDES += "cpss"

LICENSE = "CLOSED"

DEPENDS = "glibc"

SRC_URI = "https://www.marvell.com/content/dam/marvell/en/my-products/infrastructure-processors/octeon-arm/sdk/sdk11/qa/sdk11-22-08/generic-extensions/sources-cpss-SDK11.22.08.tar.bz2"
SRC_URI[sha256sum] = "01f471b59acdd74240f800c23b4788546445b00044850cc34feb3a0dffd1c227"

SRC_URI += " \
    file://0001-Change-Makefile-to-fit-yocto.patch \
    file://0002-Makefile-Remove-Werror-flag.patch \
"

S = "${WORKDIR}/cpss-SDK11.22.08"

EXTRA_OEMAKE += " \
	CC='${CC}' LD='${CC}' CROSS_COMPILE=${TARGET_PREFIX} \
"

FILES:${PN} = " \
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

INSANE_SKIP:${PN} += "ldflags"
FILES:${PN} += "${bindir}"
COMPATIBLE_MACHINE:marvell-cn106xx = "marvell-cn106xx"
COMPATIBLE_MACHINE ?= "^$"
