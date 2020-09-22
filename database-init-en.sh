#!/usr/bin/env bash
mkdir -p tool-jar
if [ ! -f hzero-tool-data-install.jar ]
then
    curl http://nexus.saas.hand-china.com/content/repositories/Hzero-Release/org/hzero/tool/hzero-installer/0.2.0.RELEASE/hzero-installer-0.2.0.RELEASE.jar -o ./hzero-tool-data-install.jar
fi

echo -e "\nHZERO 1.4 start init..............\n\n"

echo "Startup tool..."


java -Dinstaller.mapping=mapping/service-mapping.xml -jar hzero-tool-data-install.jar

