# RotasPaisFilhas

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.2.9.


**Esse projeto tem como objetivo responder ao primeiro pensar e responder do módulo de desenvolvimento mobile. A questão é apresentada como segue abaixo:**

Conforme citado no material, o angular nos permite criar módulos distintos e importar todas as suas dependências para acessar em outros módulos, formando assim uma aplicação organizada e facilitando a utilização de bibliotecas de terceiros.

Outra coisa que isso permite é distribuir a declaração de rotas entre módulos filhos, e importá-los no módulo pai. A técnica e sintaxe para isso não foi discutida, mas pode ser encontrada.

Faça uma pesquisa sobre como criar rotas filhas usando essa técnica e apresente um exemplo simples que utilize dois módulos declarando suas rotas que serão importadas no módulo pai. Teste sua aplicação local para ter certeza de que funciona.

Dicas: Pesquise por “Angular router in submodules forChild”.

A diretiva RouterModule.forChild será usada para criar rotas no módulo filho, e a diretiva RouterModule.forRoot será usada para criar rotas no módulo principal ou módulo pai. As rotas do módulo pai devem utilizar uma propriedade loadChildren para carregar o módulo em um path especifico.

Para testar no navegador utilize o path que escolher para o loadChildren, mais o path para as rotas declaradas no módulo. Exemplo: /modulo1/child1
