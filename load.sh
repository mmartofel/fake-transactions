#!/bin/bash

# URL to send requests to
URL="http://fake-transactions-instana-postgres.apps.tylp4mpb.northeurope.aroapp.io/api/fakeperson"

# Infinite loop to repeatedly send requests
while true; do

for i in {1..10}; do
  curl "$URL"
  echo
  # Optional: Add a sleep interval to avoid overwhelming the server
  sleep 0.1
done

  curl "$URL/count"
  echo " - records in table"  
  
done


