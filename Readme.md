
To run elasticsearch via docker use:
docker run -d --name es7171 -p 9200:9200 -e "discovery.type=single-node" elasticsearch:7.17.1