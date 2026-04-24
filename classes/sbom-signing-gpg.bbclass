# GPG Backend for SBOM Signing
#
# Signs SBOMs using GnuPG with detached ASCII-armored signatures.

# Conditional dependency on gnupg-native
DEPENDS:append = " ${@'gnupg-native' if d.getVar('SBOM_SIGN_ENABLED') == '1' and d.getVar('SBOM_SIGN_BACKEND') == 'gpg' else ''}"

# GPG-specific variables
SBOM_SIGN_GPG_KEY_ID ??= ""
SBOM_SIGN_GPG_HOMEDIR ??= "${HOME}/.gnupg"
SBOM_SIGN_GPG_PASSPHRASE_FILE ??= ""
SBOM_SIGN_GPG_EXTRA_ARGS ??= ""

# TODO: Implement gpg_validate function
def sbom_signing_gpg_validate(d):

    # Check if Key is present
    # Check other variables exists

    return True

# TODO: Implement function
def sbom_signing_gpg_sign(filepath, d):

    return True

python __anonymous() {
    if d.getVar('SBOM_SIGN_ENABLED') == '1' and d.getVar('SBOM_SIGN_BACKEND') == 'gpg':
        if d.getVar('IMAGE_BASENAME'):
            sbom_signing_gpg_validate(d)
}
