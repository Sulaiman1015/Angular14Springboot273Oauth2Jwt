import { Injectable } from '@angular/core';
import {HttpClient } from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../model/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`http://localhost:8080/api/empls`);
  }
  getEmployee(id: number): Observable<Employee> {
    return this.http.get<Employee>(`http://localhost:8080/api/empls/${id}`);
  }
  deleteEmployee(id: number): Observable<Employee> {
    return this.http.delete<Employee>(`http://localhost:8080/api/empls/${id}`)
  }


  addEmployee(): void {
    // @ts-ignore
    this.http.post<Employee>(`http://localhost:8080/api/empls/${id}`)

  }
}
