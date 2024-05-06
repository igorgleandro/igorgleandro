import os
import shutil
import time



# - Creation of the file for Logs

logFile = '/Users/igorgleandro/Desktop/Escritorio_Igor_iMac/myRepoGithub/TestTask_SyncFiles/src/log/sync_log.txt'



# In this section 
# - I'm defining the interval time duration (1 minute) between Sync
# - Starting the While true to be permanent on loop 
# - the Sleep function is invoked at the end of the loop.

timerDuration = 60

while True:


    # In this section:
    # - I'm defining the input folder as the user's folder (to be Synced) as the main path direction.
    # - Also, I'm using a variable to store as a string the output folder (the synced folder).
    # - After, I'm creating a list of the files from each folder.

    os.chdir('/Users/igorgleandro/Desktop/Escritorio_Igor_iMac/myRepoGithub/TestTask_SyncFiles/src/input')
    pathDestination = '/Users/igorgleandro/Desktop/Escritorio_Igor_iMac/myRepoGithub/TestTask_SyncFiles/src/output'

    inputFilesList = os.listdir()
    outputFilesList = os.listdir(pathDestination)

    # In this block:
    # - Synchronization is started, for each loop is created a log.
    # - From now on, every action will generate a log

    print("\n" + "Sync started" + "\n")
    with open(logFile, 'a') as f:
        f.write("\nSync started at: " + time.strftime("%Y-%m-%d %H:%M:%S") + "\n")

    # in this code block:
    # - For each file in the input folder is made a copy in the path destination

    for file in inputFilesList:
        shutil.copy(file, pathDestination)
        print('Sync of ' + file + " has been made.")
        
        with open(logFile, 'a') as f:
            f.write("Copied: " + file + "\n")
        

    # in this code block:
    # - A comparison between the lists is made.
    # - If the file doesn't exist in the output folder, file is removed
    # - The input and output list is updated.

    for file in outputFilesList:
        if file not in inputFilesList:
            os.remove(os.path.join(pathDestination, file))
            print(file + " has been removed from the output folder. \n")
            
            with open(logFile, 'a') as f:
                f.write("Removed: " + file + "\n")

    inputFilesList = os.listdir() 
    outputFilesList = os.listdir(pathDestination)

    # List files in the destination folder path after copy /create /remove

    print("\n" + "Files in the output folder path:")
    for file in os.listdir(pathDestination):
        print("file name: " + file)

     # In this block:
     # - End of Sync menssage
     # - Added to the Log    

    print("\n" + "Synchronizaion done.")
    with open(logFile, 'a') as f:
        f.write("Sync completed at: " + time.strftime("%Y-%m-%d %H:%M:%S") + "\n")

    time.sleep(timerDuration)
    

