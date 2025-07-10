# PowerShell script to test JWT authentication
$username = "user"
$password = "pwd"
$url = "http://localhost:8082/authenticate"

# Create credentials
$credential = [System.Convert]::ToBase64String([System.Text.Encoding]::ASCII.GetBytes("${username}:${password}"))

# Make the request
try {
    $response = Invoke-WebRequest -Uri $url -Headers @{Authorization="Basic $credential"} -Method GET
    Write-Host "Status Code: $($response.StatusCode)"
    Write-Host "Response Body:"
    Write-Host $response.Content
} catch {
    Write-Host "Error: $($_.Exception.Message)"
    Write-Host "Status Code: $($_.Exception.Response.StatusCode.value__)"
}
