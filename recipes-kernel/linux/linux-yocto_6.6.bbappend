require linux-yocto-marvell-cn10xxx.inc

KBRANCH:marvell-cn10xxx = "${@bb.utils.contains('ENABLE_MARVELL_BASE61', '1', \
			    'v6.6/standard/cn-sdkv6.1/octeon', \
			    'v6.6/standard/cn-sdkv6.6/octeon', d)}"

KERNEL_FEATURES:append:marvell-cn10xxx = "${@bb.utils.contains('ENABLE_MARVELL_BASE61', '1', \
					  ' bsp/marvell-cn10xxx/features/sdkv6.1-feature/sdkv6.1-feature.scc', \
					  ' bsp/marvell-cn10xxx/features/sdkv6.6-feature/sdkv6.6-feature.scc', d)}"
