#!/bin/bash


if [ -x "$(command -v sass)" ]; then
  SASS_EXEC=sass
fi


if [ -z "$SASS_EXEC" ]; then
  echo "You need to have SASS installed"
  exit 1
fi

sass --watch style.scss output.css