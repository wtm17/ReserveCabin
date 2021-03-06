<!DOCTYPE html>
<head>
    <title>Reserve Cabin</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <r:require modules="styles, angularJsAndBootstrapAndMore, application"/>

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
    <r:layoutResources/>
</head>

<body>
<div id="page-body" role="index">

    <div id="sn-site-wrapper" ng-app="ReserveCabin">

        <div class="container" id="mainPage"  ng-view ng-cloak>
        </div>
    </div>
</div>

<r:layoutResources/>
</body>
</html>
