#!/bin/bash

# Prompt for user input
read -p "Enter your personal GitHub name: " NAME
read -p "Enter your personal GitHub email: " EMAIL
read -p "Enter the full URL of your personal GitHub repo (e.g., https://github.com/yourname/repo.git): " REPO

# Configure git for the current repo
git config user.name "$NAME"
git config user.email "$EMAIL"
git remote remove origin 2> /dev/null
git remote add origin "$REPO"

# Show confirmation
echo -e "\n✅ Git config set for this repo:"
git config user.name
git config user.email
echo -e "\n🔗 Remote set to:"
git remote -v
