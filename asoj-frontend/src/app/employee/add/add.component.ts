import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../employee.service";
import { Employee } from 'src/app/model/employee';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  empl!: Employee;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.addEmpl();
  }

  addEmpl(){

  }

}
