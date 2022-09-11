import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import {EmployeeService} from '../employee.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  empls: Employee[] = [];
  emp!: Employee;
  id!: number;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.deleteEmployee();
    this.getEmployees();
    this.getEmployee();
    }

  deleteEmployee() {

    this.employeeService.deleteEmployee(this.id).subscribe((data: Employee): void => { this.emp = data;})
  }
  getEmployees() {
    this.employeeService.getEmployees().subscribe((data: Employee[]): void => { this.empls = data; });
  }

  getEmployee() {
    this.employeeService.getEmployee(this.id).subscribe((data: Employee): void => { this.emp = data; });
  }
}
