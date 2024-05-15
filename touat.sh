#!/bin/bash
cd `dirname $0`

server=be01

mvn -T 1C clean package -pl=be-water-server -am  -Dmaven.test.skip=true \
&& rsync -avz be-water-server/target/ddm-api-server.jar root@${server}:/opt/docker/ddm/api/app/ddm-api-server.jar \
&& ssh root@${server} 'docker restart ddm-api-server && docker logs -f --tail=10 ddm-api-server'