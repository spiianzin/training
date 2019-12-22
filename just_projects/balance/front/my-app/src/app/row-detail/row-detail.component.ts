import { Component, OnInit, Input } from '@angular/core';
import { Row } from '../row'
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { RowService }  from '../row.service';

@Component({
  selector: 'app-row-detail',
  templateUrl: './row-detail.component.html',
  styleUrls: ['./row-detail.component.css']
})
export class RowDetailComponent implements OnInit {
  @Input() row: Row;

  constructor(
    private route: ActivatedRoute,
    private rowService: RowService,
    private location: Location
  ) {}

  ngOnInit() {
    this.getRow();
  }

  getRow(): void {
    const uuid2 = this.route.snapshot.paramMap.get('uuid2');
    this.rowService.getRow(uuid2)
      .subscribe(row => this.row = row);
  }

  goBack(): void {
    this.location.back();
  }

}
