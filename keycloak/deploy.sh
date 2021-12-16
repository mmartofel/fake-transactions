oc process -f https://raw.githubusercontent.com/keycloak/keycloak-quickstarts/latest/openshift-examples/keycloak.yaml \
    -p KEYCLOAK_USER=admin \
    -p KEYCLOAK_PASSWORD=admin \
    -p NAMESPACE=dev \
| oc create -f -
