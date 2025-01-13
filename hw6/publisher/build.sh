docker buildx build . -t "slezkin71/microservice:publisher_v1"
sleep 2
echo "================================"
echo
docker push "slezkin71/microservice:publisher_v1"
echo "================================"
echo
sleep 2
helm uninstall publisher -n pub
echo "================================"
sleep 1
helm install publisher publisher-chart -n pub
echo "================================"
echo `date`
