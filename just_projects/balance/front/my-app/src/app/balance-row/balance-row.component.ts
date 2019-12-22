import { Component, OnInit } from '@angular/core';
import { ROWS } from '../mock-balance-rows'
import { Row } from '../row'
import { RowService } from '../row.service';

@Component({
  selector: 'app-balance-row',
  templateUrl: './balance-row.component.html',
  styleUrls: ['./balance-row.component.css']
})
export class BalanceRowComponent implements OnInit {
  rows: Row[];
  selectedRow: Row;

  constructor(private rowService: RowService) { }

  ngOnInit() {
    this.getRows();
  }

  getRows(): void {
    this.rowService.getRows()
        .subscribe(rows => this.rows = rows);
  }

}
