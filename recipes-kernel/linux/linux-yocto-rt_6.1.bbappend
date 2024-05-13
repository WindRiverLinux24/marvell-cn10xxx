require linux-yocto-marvell-cn10xxx.inc

KBRANCH:marvell-cn10xxx = "${@bb.utils.contains('ENABLE_MARVELL_BASE515', '0', \
                          'v6.1/standard/preempt-rt/cn-sdkv6.1/octeon', \
                          'v6.1/standard/preempt-rt/cn-sdkv5.15/octeon', d)}"
