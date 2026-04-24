SUMMARY = "Sigstore Cosign - Container and artifact signing tool"
DESCRIPTION = "Cosign is a tool for signing and verifying container images and other artifacts using Sigstore."
HOMEPAGE = "https://github.com/sigstore/cosign"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "https://github.com/sigstore/cosign/releases/download/v${PV}/cosign-linux-amd64;downloadfilename=cosign-${PV}-linux-amd64"
SRC_URI[sha256sum] = "c956e5dfcac53d52bcf058360d579472f0c1d2d9b69f55209e256fe7783f4c74"

inherit native

do_install[depends] += "cosign-native:do_fetch"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${DL_DIR}/cosign-${PV}-linux-amd64 ${D}${bindir}/cosign
}

deltask do_patch
deltask do_configure
deltask do_compile
deltask do_create_srcipk
deltask do_deploy_source_date_epoch
deltask do_create_spdx
deltask do_create_recipe_spdx

BBCLASSEXTEND = "native nativesdk"
