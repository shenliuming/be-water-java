#!/bin/bash
cd `dirname $0`

server=be01

mvn -T 1C clean package -pl=be-water-server -am  -Dmaven.test.skip=true \
&& rsync -avz be-water-server/target/be-water-server.jar root@${server}:/opt/docker/ddm/api/app/be-water-server.jar \
&& ssh root@${server} 'docker restart be-water-server && docker logs -f --tail=10 be-water-server'