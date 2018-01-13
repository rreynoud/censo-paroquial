"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var familia_component_1 = require("../familia/familia.component");
var pessoa_component_1 = require("../pessoa/pessoa.component");
var CadastroComponent = (function () {
    function CadastroComponent(http) {
        this.familia = new familia_component_1.FamiliaComponent();
        this.pessoas = [];
        this.integrante = new pessoa_component_1.PessoaComponent();
        this.http = http;
        this.familia.enderecoNumero = '';
        this.familia.enderecoRua = '';
        this.familia.enderecoTipo = '';
        this.familia.sobrenome = '';
    }
    CadastroComponent.prototype.cadastrar = function (event) {
        event.preventDefault();
        console.log(this.familia);
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        this.familia = new familia_component_1.FamiliaComponent();
        this.pessoas = [];
        // this.http.post('v1/fotos', JSON.stringify(this.familia), { headers: headers })
        // .subscribe(() => {
        //     this.familia = new FamiliaComponent()
        //     console.log('Familia salva com sucesso');
        // }, erro =>  console.log(erro));
    };
    CadastroComponent.prototype.adicionarIntegrante = function (event) {
        event.preventDefault();
        console.log(this.familia);
        var integranteAUX = new pessoa_component_1.PessoaComponent();
        integranteAUX.dataNascimento = this.integrante.dataNascimento;
        integranteAUX.nome = this.integrante.nome;
        this.pessoas.push(integranteAUX);
        this.familia.integrantes.push(integranteAUX);
        this.integrante = new pessoa_component_1.PessoaComponent();
    };
    CadastroComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'cadastro',
            templateUrl: './cadastro.component.html'
        }), 
        __metadata('design:paramtypes', [http_1.Http])
    ], CadastroComponent);
    return CadastroComponent;
}());
exports.CadastroComponent = CadastroComponent;
//# sourceMappingURL=cadastro.component.js.map