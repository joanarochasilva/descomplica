import { NgModule } from "@angular/core";
import { PaiPageComponent } from "./pai-page.component";
import { PrimeiroFilhoPageComponent } from "./primeirofilho-page.component";
import { SegundoFilhoPageComponent } from "./segundofilho-page.component";
import { PaiPageRoutingModule } from "./pai-page.routing";

@NgModule({
  declarations: [
    PaiPageComponent,
    PrimeiroFilhoPageComponent,
    SegundoFilhoPageComponent
  ],
  imports: [
    PaiPageRoutingModule,
  ],
  exports: [

  ],
  providers: []
})

export class PaiPageModule {

}
