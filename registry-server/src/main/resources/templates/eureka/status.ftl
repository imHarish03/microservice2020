<#-- Override the default status page -->
<#import "/eureka/common.ftl" as common>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${model.title}</title>
    <@common.css/>
    <#-- Add this in the head section -->
    <link href="${contextPath}/css/custom-eureka.css" rel="stylesheet">

    <#-- For any other static resources -->
    <img src="${contextPath}/images/logo.png">
    <link href="/css/custom-eureka.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-4 mb-4">${model.title}</h1>

        <div class="card mb-4">
            <div class="card-header">
                <h2>System Status</h2>
            </div>
            <div class="card-body">
                <@common.systemStatus/>
            </div>
        </div>

        <#if model.dsReplicas??>
        <div class="card mb-4">
            <div class="card-header">
                <h2>DS Replicas</h2>
            </div>
            <div class="card-body">
                <@common.dsReplicas/>
            </div>
        </div>
        </#if>

        <#if model.applications??>
        <div class="card mb-4">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h2>Instances currently registered with Eureka</h2>
                <span class="badge bg-primary">${model.applications.size()} instances</span>
            </div>
            <div class="card-body">
                <@common.applications/>
            </div>
        </div>
        </#if>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>