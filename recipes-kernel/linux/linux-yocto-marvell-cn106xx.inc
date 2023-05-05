COMPATIBLE_MACHINE:marvell-cn106xx = "marvell-cn106xx"
TARGET_SUPPORTED_KTYPES:marvell-cn106xx = "standard preempt-rt"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append:marvell-cn106xx = "${@bb.utils.contains('ENABLE_MARVELL_SDK12', '1', ' file://sdk12.cfg', '', d)}"
