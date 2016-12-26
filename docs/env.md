## 新建工程
  git init
  git add ./
  git commit -m '2016-12-26'
  git remote add origin https://github.com/shawnxjf1/springExample.git
  git push -u origin master

  ## 遇到的问题
  1. $ git remote add origin https://github.com/shawnxjf1/springExample.git
       fatal: remote origin already exists.
     解决办法：
     git remote rm origin

