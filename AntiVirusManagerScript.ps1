$hostname = hostname
$computer_ip = "192.0.0.1"
# How to find the computer ip that you want to compare ?

$exclusions_url = "http://localhost:8081/exclusions/getExclusionsByHostName/"+ $hostname

$computer_add_url = "http://localhost:8081/api/addHost"


$exclusions = Invoke-RestMethod $exclusions_url 

$exclusion_path = $exclusions[0].folderPath

$exclusion_ip = $exclusions[0].ipAddress


if (($exclusion_path -notcontains "") -and ($exclusion_ip -eq $computer_ip) ) {

   Add-MpPreference -ExclusionPath “$exclusion_path”
}
 
 
$computer_status= Get-MpComputerStatus | Select-Object -Property AntispywareEnabled,AntispywareSignatureAge,AntispywareSignatureLastUpdated,AntispywareSignatureVersion , AntivirusEnabled,AntivirusSignatureAge,AntivirusSignatureLastUpdated , AntivirusSignatureVersion ,BehaviorMonitorEnabled, ComputerID 


$computer_status | Add-Member -Type NoteProperty -Name 'hostName' -Value $hostname

#modify the details of the computer status or add all the details to a new variable 

$computer_status_parameters = @{
    Method = "POST"
    Uri =  ($computer_add_url)
    Body = ($computer_status) 
    ContentType = "application/json"
}
 Invoke-RestMethod @computer_status_parameters