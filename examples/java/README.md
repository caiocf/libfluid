# Java bindings for libfluid_base
This is an implementation of a Java binding for **libfluid**.

The `Makefile` for this example assumes you have **libfluid_base** and 
**libfluid_msg** installed in your system with the `/usr` prefix. It also needs 
Swig 2.0 and the JDK (`openjdk-7-jdk` package on Ubuntu 12.04). 

So do what's needed first, and then run:
~~~{.sh}
$ make
OpenFlow 1.0
$ LD_LIBRARY_PATH=./fluid:$LD_LIBRARY_PATH java LearningSwitch
OR OpenFlow 1.3
$ LD_LIBRARY_PATH=./fluid:$LD_LIBRARY_PATH java LearningSwitch13
~~~

It is an OpenFlow 1.0 learning switch test application.

The Java code is in `LearningSwitch.java`.

It is an OpenFlow 1.3 learning switch test application.
The Java code is in `LearningSwitch13.java`.

> This example uses the new, IANA-defined OpenFlow port: **6653** instead of 
> the previous, non-standard default (6633).
> Exemple Conection Mininet Openflow Protocolo Version 1.0:
> >  sudo mn -v output --topo linear,5  --switch ovs,protocols=OpenFlow10 --controller remote,ip=[IP],port=6653
     Or Version 1.3
> >  sudo mn -v output --topo linear,5  --switch ovs,protocols=OpenFlow13 --controller remote,ip=[IP],port=6653
