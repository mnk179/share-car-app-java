# share-car-app

<b>Dependency tree</b>

<ul>
<li>module "api" knows noone</li>
<li>module "service" knows about "api" and "repository"</li>
<li>module "repository" knows noone"</li>
</ul>

Module "<i>service</i>" is suppose to be main executable jar, so it contains spring boot application though.

Modules "talk" with each other through <i>interfaces</i>. Such ones are placed under "<i>/spi/</i>" package.

How to run it:

<ol>
<li>run <i>mvn clean compile</i></li>
<li>run application using IntelliJ spring boot configuration</li>
</ol>



