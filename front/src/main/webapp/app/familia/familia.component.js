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
var FamiliaComponent = (function () {
    function FamiliaComponent() {
        this.sobreNome = '';
        this.enderecoRua = '';
        this.enderecoNumero = '';
        this.enderecoTipo = '';
        this.persons = [];
    }
    __decorate([
        core_1.Input(), 
        __metadata('design:type', String)
    ], FamiliaComponent.prototype, "sobreNome", void 0);
    __decorate([
        core_1.Input(), 
        __metadata('design:type', String)
    ], FamiliaComponent.prototype, "enderecoRua", void 0);
    __decorate([
        core_1.Input(), 
        __metadata('design:type', String)
    ], FamiliaComponent.prototype, "enderecoNumero", void 0);
    __decorate([
        core_1.Input(), 
        __metadata('design:type', String)
    ], FamiliaComponent.prototype, "enderecoTipo", void 0);
    __decorate([
        core_1.Input(), 
        __metadata('design:type', Array)
    ], FamiliaComponent.prototype, "persons", void 0);
    FamiliaComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'familia',
            templateUrl: './familia.component.html'
        }), 
        __metadata('design:paramtypes', [])
    ], FamiliaComponent);
    return FamiliaComponent;
}());
exports.FamiliaComponent = FamiliaComponent;
//# sourceMappingURL=familia.component.js.map