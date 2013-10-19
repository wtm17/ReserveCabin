<!DOCTYPE html>
<head>
    <title>Reserve Cabin</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">

    <link href="css/style.css" rel="stylesheet">

<!--[if lte IE 8]>
        <script>
            document.createElement('ng-include');
            document.createElement('ng-pluralize');
            document.createElement('ng-view');

            // Optionally these for CSS
            document.createElement('ng:include');
            document.createElement('ng:pluralize');
            document.createElement('ng:view');
        </script>
    <![endif]-->
</head>

<body>
<div id="page-body" role="index">
    <div class="visible-desktop"><hr></div>
    <div id="sn-site-wrapper" ng-app="reservecabin">

        <div class="container" id="indexPage"  ng-view ng-cloak>
        </div>
    </div>
</div>

</body>
<g:if env="development">
    <r:layoutResources/>
</g:if>
<g:else>
    <script type="text/javascript" src="js/application.js"></script>
</g:else>
</html>
