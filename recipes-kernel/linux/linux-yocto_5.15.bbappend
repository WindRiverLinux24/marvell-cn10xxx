KBRANCH:marvell-cn106xx = "${@bb.utils.contains('ENABLE_MARVELL_SDK12', '1', \
                          'v5.15/standard/cn-sdkv5.15/octeon', \
                          'v5.15/standard/cn-sdkv5.4/octeon', d)}"

require linux-yocto-marvell-cn106xx.inc
