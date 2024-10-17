mvn install
docker build --no-cache -t hw2:srv1 .
docker run -d -p 8000:8000 $(docker image ls hw2 -q)