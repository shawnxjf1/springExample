curDir=./
git add ./
echo 'git add $curDir'
git pull ./
##date 命令赋值使用$()
comment=$(date "+%Y-%m-%d")
git commit -m $comment
echo git push $curDir
git push
