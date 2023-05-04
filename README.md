# pi

A platform to experiment with yocto and and bitbake, targeting a raspberry pi.

## Steps

- `. init.sh`
- if not done, add the layers with `bitbake-layers add-layer ./path/to/layer`
- run bitbake: `bitbake core-image-base -k`
- [flash image](https://docs.yoctoproject.org/dev/dev-manual/bmaptool.html):
    - if necessary, unmount the card: `sudo umount /media/joergmis/boot`
    - find sdcard: `mount | grep "/dev"`
    - `sudo chmod 666 /dev/sdb1`
    - `oe-run-native bmap-tools-native bmaptool copy tmp/deploy/images/raspberrypi3-64/core-image-base-raspberrypi3-64.wic.bz2 /dev/sdb1`

## Resources

### General

- [serial console pi 3](https://www.jeffgeerling.com/blog/2021/attaching-raspberry-pis-serial-console-uart-debugging)
- [serial console on pi zero](https://c2plabs.com/blog/2019/04/23/enable-serial-console-on-raspberry-pi-zero-w/)
- [build an image for the sdcard](https://raspberrypi.stackexchange.com/questions/57155/how-do-i-use-yocto-to-build-an-sdcard-image-for-my-raspberry-pi-3-model-b)
- [yocto + radio tutorial](https://embeddeduse.com/2020/05/26/qt-embedded-systems-1-build-linux-image-with-yocto/)
- [yocto for pi 3](https://raspinterest.wordpress.com/2016/11/30/yocto-project-on-raspberry-pi-3/)
- [building a linux distro for pi 3](https://www.lysator.liu.se/inbyggda-hack/pi/)
- [ready set yocto - unofficial guide](https://github.com/jynik/ready-set-yocto)

### Recipes

- [writing a new recipe - yoctoproject](https://docs.yoctoproject.org/dev-manual/common-tasks.html#writing-a-new-recipe)