import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { BankmgmtService } from './bankmgmt/bankmgmt.service';
import { BankmgmtComponent } from './bankmgmt/bankmgmt.component';

@NgModule({
  imports:      [ BrowserModule, FormsModule,HttpClientModule ],
  declarations: [ AppComponent, BankmgmtComponent ],
  bootstrap:    [ AppComponent ],
  providers: [BankmgmtService]
})
export class AppModule { }
