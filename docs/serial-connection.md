# Serial Connection

To get uart working with the pi, you need to do the following:

- enable uart
- force turbo
- append the rpi-config

Both settings can be set in `local.conf`.

```
# local.con
ENABLE_UART = "1"
INSTALL:append = " rpi-config"
RPI_EXTRA_CONFIG = ' \n \
    force_turbo=1 \n \
    '
```

The following pins are used for the serial connection (layout when the pins are
on the top left corner):

- `A2` is the black wire
- `A3` is the white wire
- `A4` is the green wire

```
  0 1 2 3 4 5
A o o x x x o ...
B o o o o o o ...
```

Connection to the pi:

```sh
sudo tio /dev/ttyUSB0
```

