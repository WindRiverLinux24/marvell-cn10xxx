COMPATIBLE_MACHINE:marvell-cn106xx = "marvell-cn106xx"
TARGET_SUPPORTED_KTYPES:marvell-cn106xx = "standard preempt-rt"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append:marvell-cn106xx = " file://marvell-cn106xx-Setting-the-Default-Power-Management.cfg"
