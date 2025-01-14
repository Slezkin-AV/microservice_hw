helm uninstall publisher -n pub
echo "================================"
echo
sleep 1
docker buildx build . -t "slezkin71/microservice:publisher_v1"
sleep 1
echo "================================"
echo
docker push "slezkin71/microservice:publisher_v1"
echo "================================"
echo
sleep 1
helm install publisher publisher-chart -n pub
echo "================================"
echo `date`
echo