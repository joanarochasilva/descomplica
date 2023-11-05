import { NgModule } from "@angular/core";
import { Routes, RouterModule } from '@angular/router'

import { PaiPageComponent } from "./pai-page.component";
import { PrimeiroFilhoPageComponent } from "./primeirofilho-page.component";
import { SegundoFilhoPageComponent } from "./segundofilho-page.component";

const routes: Routes = [
  {
    path: '',
    component: PaiPageComponent,
    children: [
      {path : '', redirectTo: 'primeirofilho', pathMatch: 'full'},
      {path: 'primeirofilho', component: PrimeiroFilhoPageComponent},
      {path: 'segundofilho', component: SegundoFilhoPageComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaiPageRoutingModule {}