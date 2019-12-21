import { Component, OnInit } from '@angular/core';
import { Row } from '../row'
import { RowService } from '../row.service'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  rows: Row[] = [];

  constructor(private rowService: RowService) { }

  ngOnInit() {
    this.getRows();
  }

  getRows(): void {
    this.rowService.getRows()
        .subscribe(rows => this.rows = rows.slice(1, 5));
  }


}
