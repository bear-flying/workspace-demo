#!/bin/bash

date=`date +\%Y%m%d%H%M`
#define db name, change it firstly
db_name="db_name"
#define db username, change it firstly
db_username="ids"
#define db password, change it firstly
db_password="ids"
#backup path, must end by '/', change it firstly
backup_path="/home/backup/database/"


#define tar file name
tar_file_name="${db_name}-${date}.tar.gz"

#delete if existes files
rm -rf $db_name
rm -rf $tar_file_name

echo "----- Start dumping MongoDB: ${db_name}, dumped tar file: ${tar_file_name} -----"
#Call dump,  Change it firstly
/home/ubuntu/mongodb/mongodb-linux-x86_64-2.6.12/bin/mongodump -h 127.0.0.1:27318 -u $db_username -p $db_password -d $db_name -o $backup_path

#tar file
tar_dir="${backup_path}${db_name}"
echo "Tar database file path: ${tar_dir}"
tar czvf $tar_file_name $tar_dir



#Clean
echo "Remove created files: ${tar_dir}"
rm -rf $tar_dir
#rm -rf $tar_file_name

echo "-------Dump ${db_name} finished -------"

