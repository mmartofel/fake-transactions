#!/bin/bash

# URL to send requests to
URL="http://fake-transactions-instana-postgres.apps.c1t8m3zl.westus.aroapp.io/api/fakeperson"

# Infinite loop to repeatedly send requests
while true; do
  curl "$URL"
  echo
  # Optional: Add a sleep interval to avoid overwhelming the server
  sleep 0.1

  curl "$URL/count"
  echo " - records in table"  
  
done


