DATA PERSISTENCE
-------------------
	1) How to persist rdb data - time driven snapshotting.
		In redis.conf
			dir <DIRECTORY WHERE LOG FILE GOES>
			save "10 10" #Save every 10 seconds if there are at least 10 keys changed(added or updated) 
			dbfilename <DUMP_FILE_NAME>.rdb
		Start the server with the conf file redis-server.exe conf/redis.conf
	
	2) How to persist aof data - event driven logging. Every transaction gets logged.
		In redis.conf
			dir d://temp
		 	appendonly yes (this will create filename called appendonly.aof in <dir>)
		Start the server with the conf file redis-server.exe conf/redis.conf 	
	 	 
	3) When redis restarts, it will automatically load the data from dir/dbfilename. Make sure you load the server with configuration file when starting.

SECURITY
----------


References
https://raw.github.com/antirez/redis/2.2/redis.conf
http://redis.io/commands/config-set
http://www.ibm.com/developerworks/opensource/library/os-springredis/index.html
https://github.com/dmajkic/redis/downloads

Monitor what's happening  - ./redis-client monitor Or start redis-client and execute monitor
Get list configuration parameters - in redis-client, execute config get *
Get a specific configuration - in redis-client, execute config get *
Set a specific configuration - in redis-client, execute config get *