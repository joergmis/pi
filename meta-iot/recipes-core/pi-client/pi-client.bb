DESCRIPTION = "pi-client"
LICENSE = "CLOSED"

SRCBRANCH ?= "main"
SRCREV ?= "${AUTOREV}"
SRC_URI = "git://github.com/joergmis/pi-client.git;protocol=https;branch=${SRCBRANCH}"

DEPENDS = "go-native"

S = "${WORKDIR}/git"

inherit goarch

do_compile() {
    mkdir -p ${B}/cache/go-build
    mkdir -p ${B}/.config/go/env
    mkdir -p ${B}/go/mod/cache/go-build

    export GOOS="${TARGET_GOOS}"
    export GOARCH="${TARGET_GOARCH}"
    export GOMOD="${B}/git/go.mod"
    export GOPATH="${B}/go"
    export GOMODCACHE="${B}/go/mod/cache"
    export GOCACHE="${B}/go/mod/cache/go-build"
    export GOENV="${B}/.config/go/env"
    export GOPROXY="direct"

    go install github.com/joergmis/pi-client/cmd/client
}

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/go/${GO_BUILD_BINDIR}/client ${D}${bindir}
}
