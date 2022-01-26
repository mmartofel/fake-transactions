./mvnw clean package \
    -Dquarkus.container-image.build=true \
    -Dquarkus.kubernetes-client.trust-certs=true \
    -DskipTests \
  -Dquarkus.profile=ocp

