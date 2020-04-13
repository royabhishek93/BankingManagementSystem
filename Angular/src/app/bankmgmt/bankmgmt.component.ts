import { Component, OnInit } from "@angular/core";
import { Customer } from "./customer";
import { BankmgmtService } from "./bankmgmt.service";
import { NgForm } from "@angular/forms";

@Component({
  selector: "app-bankmgmt",
  templateUrl: "./bankmgmt.component.html",
  styleUrls: ["./bankmgmt.component.css"]
})
export class BankmgmtComponent implements OnInit {
  constructor(private bankmgmtService: BankmgmtService) {}

  ngOnInit() {
    this.getAllCustomers();
  }
  allCustomers: Customer[];

  getAllCustomers() {
    this.bankmgmtService
      .getAllCustomers()
      .subscribe(
        data => (this.allCustomers = data),
        errorCode => (this.statusCode = errorCode)
      );
  }


}
