KBRANCH_marvell-cn106xx  = "v5.10/standard/preempt-rt/cn-sdkv5.4/octeon"

require linux-yocto-marvell-cn106xx.inc

TARGET_SUPPORTED_KTYPES_append_marvell-cn106xx = " preempt-rt"

LINUX_VERSION_marvell-cn106xx ?= "5.10.x"
